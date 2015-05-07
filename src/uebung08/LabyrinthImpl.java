package uebung08;
import static gdi.MakeItSimple.*;

public class LabyrinthImpl implements Labyrinth 
{
    final char WAY_ERR = 'X';
        
    int rows = 0;
    int columns = 0;
    char[][] labyrinth;
    Position entrance = null;
    Position exit = null;
    Position current = null;
    boolean goBack = false;
    
    @Override
    public void readFromFile(String filename) 
    {
        if (!isFilePresent(filename) || !isFileReadable(filename))
        {
            throw new GDIException("Datei nicht lesbar: "+filename);
        }
        
        initRowsColumns(filename);
        
        intLabyrinth(filename);
    }
    
    /**
     * Zählt die Spalten und Reihen, prüft auch ob die Reihen gleich lang sind und mindestens 3 Reihen/Spalten existieren
     * @param filename 
     */
    private void initRowsColumns(String filename)
    {
        Object labfile = openInputFile(filename);
        
        int lastLine = -1;
        
        // Alle Zeilen durchgehen
        while (!isEndOfInputFile(labfile))
        {
            String line = readLine(labfile);
            int length = line.length();
            
            if (lastLine > -1 && length != lastLine)
            {
                // Wenn letzte Zeile != aktueller Zeile:
                throw new GDIException("Spalten nicht gleich lang!");
            }
            
            lastLine = length;
            this.columns++;
        }
        
        this.rows = lastLine;
        
        if (this.columns <= 3 || this.rows <= 3)
        {
            // Labyrinth nicht größer als 3x3
            throw new GDIException("Labyrinth muss größer als 3 Spalten und 3 Reihen sein!");
        }
        
        closeInputFile(labfile);
    }
    
    /**
     * Initialisiert das Labyrinth Array und übeprüft ob nur zulässige Zeichen verwendet wurden 
     * und ob es mehrere/keine Eingänge gibt.
     * @param filename 
     */
    private void intLabyrinth(String filename)
    {
        Object labfile = openInputFile(filename);
        this.labyrinth = new char[this.rows][this.columns];
        int row = 0;
        boolean foundEntrance = false;
        
        // Alle Zeilen durchgehen
        while (!isEndOfInputFile(labfile))
        {
            String line = readLine(labfile);
            
            // Alle Spalten durchgehen
            for (int column = 0; column < columns; column++ )
            {
                char curChar = line.charAt(column);
                
                if (!isLabyrinthChar(curChar))
                {
                    throw new GDIException("Unzulässiges Zeichen");
                }
                
                if (curChar == ENTRANCE_CHAR)
                {
                    if (foundEntrance) // Wenn bereits einer gefunden -> Exception
                    {
                        throw new GDIException("Mehrere Eingänge gefunden!");
                    }
                    
                    // Aktuelle Position als Eingang setzen
                    foundEntrance = true;
                    this.entrance = new Position(row, column);
                }
                
                this.labyrinth[row][column] = curChar;
            }
            
            row++;
        }
        
        
        if (!foundEntrance)
        {
            throw new GDIException("Kein Eingang gefunden!");
        }
        
        closeInputFile(labfile);
    }
    
    /**
     * Prüft ob das Zeichen zugelassen ist für ein Labyrinth
     * @param character
     * @return 
     */
    public boolean isLabyrinthChar(char character)
    {
        return (character == ENTRANCE_CHAR || character == WALL_CHAR || character == EMPTY);
    }

    @Override
    public void findWay() 
    {
        boolean go = true;
        this.current = this.entrance;
        
        //println(this.entrance);
        
        while (go)
        {
            // Aktuelle Position mit Wegzeichen setzen
            this.labyrinth[this.current.getRow()][this.current.getCol()] = WAY_CHAR;
            
            // Nächste Position ermitteln
            Position pos = getNextPossiblePosition(EMPTY);

            if (pos == null)
            {
                // Sackgasse, dann Weg zurück
                this.labyrinth[this.current.getRow()][this.current.getCol()] = WAY_ERR;
                pos = getNextPossiblePosition(WAY_CHAR);
            }

            // Aktuelle Position ändern
            this.current = pos;

            if (pos.getCol() == this.entrance.getCol() && pos.getRow() == this.entrance.getRow())
            {
                // Ist einmal durchs ganze Labyrinth und wieder zurück
                this.labyrinth[this.current.getRow()][this.current.getCol()] = ENTRANCE_CHAR;
                throw new GDIException("Kein Weg gefunden!");
            }
            else if (pos.getCol() == 0 || pos.getRow() == 0 || pos.getCol() == columns-1 || pos.getRow() == rows-1)
            {
                // Randpunkt = Ausgang gefunden
                this.labyrinth[this.current.getRow()][this.current.getCol()] = WAY_CHAR;
                go = false;
            }
        }
    }
    
    /**
     * Gibt die nächst mögliche Position aus.
     * @param allowedChar Erlaubtes Zeichen (Bspw.: ' ' für Weg, oder '.' für bereits zurück gelegten Weg)
     * @return 
     */
    public Position getNextPossiblePosition(char allowedChar)
    {
        Position pos = this.current;
        int row = pos.getRow();
        int col = pos.getCol();
        
        if (row+1 <= rows-1 && this.labyrinth[row+1][col] == allowedChar) //unten
            row = row+1;
        else if (col+1 <= columns-1 && this.labyrinth[row][col+1] == allowedChar) // rechts
            col = col+1;
        else if (row-1 >= 0 && this.labyrinth[row-1][col] == allowedChar) // oben
            row = row-1;
        else if (col-1 >= 0 && this.labyrinth[row][col-1] == allowedChar) // links
            col = col-1;
        
        if (pos.getRow() != row || pos.getCol() != col) // Neue Position gefunden
            return new Position(row,col);
        else
            return null; // Sackgasse
    }
    
    @Override
    public String toString()
    {
        String output = "";
        // Alle Zeilen durchgehen
        for (int row = 0; row < rows; row++ )
        {
            // Alle Spalten durchgehen
            for (int column = 0; column < columns; column++ )
            {
                char curChar = this.labyrinth[row][column];
                if (curChar == 'X') // X von Sackgasse wieder leeren
                    curChar = ' ';
                output += curChar;
            }
            output += "\n";
        }
        return output;
    }

    @Override
    public int numberOfRows() {
        return this.rows;
    }

    @Override
    public int numberOfColumns() {
        return this.columns;
    }

    @Override
    public Position entrancePosition() {
        return this.entrance;
    }

    @Override
    public Position exitPosition() {
        return this.exit;
    }
    
}
