package playmusic;

import java.io.File;

public class CountFileNo {
	public int countFileNo (File file){
		int number=0;
		/*File[] dirs = file.listFiles();
        String name = "";
        if (dirs != null) { // Sanity check
            for (File dir : dirs) {
                if (dir.isFile()) { // Check file or directory
                    name = dir.getName().toLowerCase();
                    // Add or delete extensions as needed
                   number++;
                }
            }
        }*/
		
		number = file.list().length;

        return number;
		
	}

	public static void main(String[] args) {
		String str = "C:\\audio\\aac\\adts";
		File fi = new File(str);
		CountFileNo cf = new CountFileNo();
		System.out.println(cf.countFileNo(fi));
		// TODO Auto-generated method stub

	}

}
