package a1_BI12_019;

public class test {
	public static void main (String[] args) {
		Student[] st = new Student[4];
		st[0] = new UndergradStudent(12019,"Quynh Anh","0975858627","Cau Dien");
		st[1] = new UndergradStudent(12263,"Phuong Mai","0987654321","Ho Tay");
		st[2] = new PostgradStudent(11011,"Gia Bao","0398765432","Cau Giay",3.9f);
		st[3] = new PostgradStudent(11098,"Thanh Binh","0371098411","Truong Chinh", 3.5f);
		
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].toString());
		}
		
		System.out.println(st[0].compareTo(st[1]));
	}
}
