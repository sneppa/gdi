package uebung09;

public class ApartmentImplementation implements Apartment {

	private String name;
	private String description;
	private MyLinkedList occupation;
	
	public ApartmentImplementation(String name, String description) {
		setName(name);
		setDescription(description);
		occupation = new MyLinkedList();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription () {
		return this.description;
	}
	
	public void addOccupation(Date fromIncluded, Date toIncluded) {
		if(!isAvailable(fromIncluded,toIncluded))
			return;
		
		occupation.addLast(new ListNode(fromIncluded,null));
		occupation.addLast(new ListNode(toIncluded,null));
	}
	
	public Object getOccupation(int index) {
		return occupation.getAt(index).getContent();
	}
	
	public boolean isAvailable(Date fromIncluded, Date toIncluded) {
		for(int i = 0; i < occupation.size(); i++) {
			Date date = (Date) occupation.getAt(i).getContent();
			if(!date.isBefore(fromIncluded))
				if(date.isBefore(toIncluded)) //inside time frame?
					return false;
		}
		
		//no discrepancies found
		return true;
	}

	public Date firstOccupiedDayAfter(Date firstDay) {
		Date lastDay = new Date(31,12);
		Date current = new Date(firstDay);
		Date next = new Date(firstDay);
		next.addDays(1);
		while(!current.equals(lastDay)) {
			if(isAvailable(current,next))
				return current;
			current.addDays(1);
			next.addDays(1);
		}
		return lastDay;
	}
	
	public String toString() {
		return name + ": \n" + description;
	}
}
