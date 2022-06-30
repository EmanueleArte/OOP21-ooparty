package utils;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

/**
 * Extension of {@link IntegerSpinnerValueFactory}
 */
public final class IntSpinnerValueFactory extends IntegerSpinnerValueFactory { 

	  public IntSpinnerValueFactory(final int min, final int max) { 
	    super(min, max); 
	  } 

	  public IntSpinnerValueFactory(final int min, final int max, final int initialValue) { 
	    super(min, max, initialValue, 1); 
	  } 

	  @Override 
	  public void increment(final int steps) { 
	    final int max = getMax(); 
	    final int currentValue = getValue(); 
	    final int newIndex = currentValue + steps * getAmountToStepBy(); 
	    setValue(newIndex <= max ? newIndex : max); 
	  }
	  
	  @Override 
	  public void decrement(final int steps) { 
	    final int min = getMin(); 
	    final int currentValue = getValue(); 
	    final int newIndex = currentValue - steps * getAmountToStepBy(); 
	    setValue(newIndex >= min ? newIndex : min); 
	  }

	}