package Assignment.main.customlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class CustomArrayListTest {

	@Test
	void should_add_15_items_causing_array_to_grow() {

		// Assign
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		for (int i = 0; i < 15; i++) {
			sut.add(i + 1);
		}
		Integer expected12thElement = sut.get(11);

		// Assert
		assertEquals(12, expected12thElement);
	}

	@Test
	void should_add_item_at_specified_index_to_existing_array() {
		// Assign
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		for (int i = 0; i < 15; i++) {
			sut.add(i + 1);
		}

		sut.add(7, 16);

		
		//Assert
		for (int i = 0; i < sut.getSize(); i++) {

			if (i == 7) {
				assertEquals(16, sut.get(7));
			} else if (i < 7) {
				assertEquals(i + 1, sut.get(i));
			} else {
				assertEquals(i, sut.get(i));
			}
		}

	}
	
	
	@Test
	void remove_item_at_specified_index_and_shuffle_items_accordingly () {
		//Assign 
		CustomList<Integer> sut = new CustomArrayList<>();
		
		for (int i = 0; i < 25; i++) {
			sut.add(i + 1);
		}
		
		@SuppressWarnings("unused")
		Integer number14TakenAway = sut.remove(13);
		
		assertEquals(14, number14TakenAway);
		
		for (int i = 0; i < sut.getSize(); i++) {
			
			if(sut.get(i)< number14TakenAway) {
				assertEquals(i + 1, sut.get(i));
			} else {
				assertEquals(i + 2, sut.get(i));
			}
		}
		
		
	}
	
	@Test
	void adding_an_index_thats_out_of_bounds_from_array () {
	
		CustomList<Integer> sut = new CustomArrayList<>();
		 for (int i = 0; i < 500; i++) {
			 sut.add(i);
		 }
		 
		 
		 assertThrows(IndexOutOfBoundsException.class, () -> sut.add(5000, 25));
		
	}

}
