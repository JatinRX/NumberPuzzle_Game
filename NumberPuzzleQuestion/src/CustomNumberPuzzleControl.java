import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		
//		emptyCellId = Integer.parseInt(buttonClicked.getLabel());
		int clickedCellId = -1;
		for (int i=0; i<16; i++) {
			if (buttons[i] == buttonClicked) {
				clickedCellId = i;
			}
		}
		int diff = emptyCellId - clickedCellId;
		if ((diff == 1) || (diff == -1) || (diff == 4) || (diff == -4))
		{
			swapButton(buttons[emptyCellId], buttonClicked);
			System.out.println(clickedCellId);
//		game.setEmptyCellId(clickedCellId);
			emptyCellId = clickedCellId;
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int flag = 0;
		for(int i=0; i<15; i++) {
			flag = 0;
			int num = (getRandomNumber()%15) + 1;
			for(int j=0; j<15; j++) {
				if(arr[j] == num) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				arr[i] = num;
			}
			else {
				i--;
			}
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for(int i=0; i<15; i++) {
			if (arr[i] != i+1) {
				return false;
			}
		}
		
		return winner;
	}
}