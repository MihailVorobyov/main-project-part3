package homework_01.big_task;

import java.util.ArrayList;

// b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
// нельзя сложить и яблоки, и апельсины;
public class Box<T extends Fruit> {

	// c. Для хранения фруктов внутри коробки можете использовать ArrayList;
	private ArrayList<T> list = new ArrayList<>();

	// d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес
	// яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
	public float getWeight() {
		if (!list.isEmpty()) {
			return list.size() * list.get(0).getWEIGHT();
		} else {
			return 0.0f;
		}
	}

	// e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
	public boolean compare (Box box) {
		return this.getWeight() == box.getWeight();
	}

	// g. Не забываем про метод добавления фрукта в коробку.
	public void put (T t) {
		list.add(t);
		System.out.println(t + " добавлен(о) в коробку");
	}



//	f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
	public void merge(Box<T> targetBox) {
		for (T t : list) {
			targetBox.put(t);
		}
		list.clear();
	}
}


