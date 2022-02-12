package Assignment.main.customlist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	
	@Override
	public boolean add(T item) {
		if (items.length == size) {
			growBackingArray();

			items[size++] = item;
			return true;

		} else if (size < items.length) {

			items[size++] = item;
			return true;

		} else {
			return false;

		}

	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {

		if (index <= size) {
			Object[] placeHolder = new Object[size + 1];

			for (int i = 0; i < index; i++) {
				placeHolder[i] = items[i];
			}
			placeHolder[index] = item;

			for (int i = index + 1; i < placeHolder.length; i++) {
				placeHolder[i] = items[i - 1];
			}
			items = placeHolder;
			size++;
			return true;

		}  else if (index < 0 || index > size ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for this instantiation of the Array");
		} else {
			return false;
		
		}

	}

	// this code works as expected
	@Override
	public int getSize() {
		return size;
	}

	// this code works as expected
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		
		if (index < 0 || index > size ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for this instantiation of the Array");
		} else {
			
			return (T) items[index];
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {

		
		if (index < 0 || index > size ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for this instantiation of the Array");
		}else if (index <= size) {
			T itemToRemove = (T) items[index];

			size--;

			Object[] placeHolderArray = new Object[size];

			// places the objects in the items Array up until the point of the identified Object
			// to be removed
			for (int i = 0; i < index; i++) {
				placeHolderArray[i] = items[i];
			}

			// places the objects in the items Array after the specified index to be removed
			for (int i = index + 1; i < placeHolderArray.length + 1; i++) {
				placeHolderArray[i - 1] = items[i];
			}

			items = placeHolderArray;

			return itemToRemove;
		} else {

			return null;
		}

	}

	// accessory method for when the Array needs to grow to accomidate added
	// elements
	private void growBackingArray() {
		Object[] placeHolderArray = new Object[size];
		for (int i = 0; i < size; i++) {
			placeHolderArray[i] = items[i];
		}

		items = new Object[size * 2];
		for (int i = 0; i < size; i++) {
			items[i] = placeHolderArray[i];
		}

	}

}
