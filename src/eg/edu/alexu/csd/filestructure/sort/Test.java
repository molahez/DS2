package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Heap h = new Heap();
		List<Integer> unordered = new ArrayList<>();
		unordered.add(4);
		unordered.add(1);
		unordered.add(3);
		unordered.add(2);
		unordered.add(16);
		unordered.add(9);
		unordered.add(10);
		unordered.add(14);
		unordered.add(8);
		unordered.add(7);

		h.build(unordered);
		
		h.extract();

	}

}
