package info.account.commands;

public enum Command {
	DISPLAY(1), EDIT(2), ADD(3), DELETE(4), QUIT(5);
	
	private int value;
	
	private Command(int value) {
		this.value = value;
	}
	
	
	
	//Display the proper output for each Command value.
	@Override
	public String toString() {		
		switch(this) {
			case DISPLAY:
				System.out.println(value + ") Display saved accounts");
				break;
			case EDIT:
				System.out.println(value + ") Edit an existing entry");
				break;
			case ADD:
				System.out.println(value + ") Add a new entry");
				break;
			case DELETE:
				System.out.println(value + ") Delete an entry");
				break;
			case QUIT:
				System.out.println(value + ") Quit");
				break;
		}
		return super.toString();
	}
	

}
