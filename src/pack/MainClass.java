package pack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		String path = "";
		String outpath = "";
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

			if (nbLine == nbLines + 1) {
				nbLine -= nbLines + 1;
				lines.add(text);
				text = ",,,\n";
			}
		}

		lines.add(text);
		scan.close();
		for (int i = 0; i < lines.size(); i++) {
			Files.write(Paths.get(outpath + "-part-" + i + ".csv"), lines.get(i).getBytes());
		}

	}

}
