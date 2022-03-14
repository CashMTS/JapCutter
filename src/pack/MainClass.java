package pack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		String path = "C:\\Users\\mathi\\Documents\\Japonais\\Kotoba\\git\\n2.csv";
		String outpath = "C:\\Users\\mathi\\Documents\\Japonais\\Kotoba\\git\\out\\n2";
		try {
			cutPack(path, outpath, 30);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void cutPack(String path, String outpath, int nbLines) throws IOException {
		int nbLine = 0;
		ArrayList<String> lines = new ArrayList<>();
		File f = new File(path);

		Scanner scan = new Scanner(f);
		String text = ",,,\n";
		String line = scan.nextLine();

		while (scan.hasNext()) {
			line = scan.nextLine();
			nbLine++;
			text += line + "\n";

			if (nbLine == nbLines) {
				nbLine -= nbLines;
				lines.add(text);
				text = ",,,\n";
			}
		}

		lines.add(text);
		scan.close();
		for (int i = 0; i < lines.size(); i++) {
			File f1 = new File(outpath + "-part-" + i + ".csv");
			f1.createNewFile();
			Files.write(Paths.get(outpath + "-part-" + i + ".csv"), lines.get(i).getBytes());
		}

	}

}
