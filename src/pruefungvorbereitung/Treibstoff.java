/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruefungvorbereitung;

/**
 *
 * @author pi
 */
enum Treibstoff {
 
    BENZIN("Benzin 95"),
    DIESEL("Diesel"),
    SUPER("Super 98"),
    E10("Benzin 90");
    
    private final String name;
    
    Treibstoff(String name)
    {
        this.name = name;
    }
    
    public String toString()
    {
        return name;
    }
    
}
