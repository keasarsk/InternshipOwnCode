package com.sk.Csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 合并两个 csv 文件，让其内容交替写入新文件
public class MergeCsv {
    public void merge(String file1Path, String file2Path, String mergedFilePath) throws IOException {

        // 创建一个新的 CSV 文件
        File mergedFile = new File(mergedFilePath);
        mergedFile.createNewFile();

        // 创建读取两个 CSV 文件的 BufferedReader 对象
        BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));

        // 创建写入合并后的 CSV 文件的 BufferedWriter 对象
        BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile));

        String line1, line2;
        // 利用循环逐行读取两个 CSV 文件，并将它们交替写入合并后的 CSV 文件中
        while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
            writer.write(line1 + "\n"); // 先写入第一个文件的当前行，并在末尾加上换行符
            //writer.write("\n"); // 在第一个文件的当前行和第二个文件的当前行之间加入空行
            writer.write(line2 + "\n"); // 再写入第二个文件的当前行，并在末尾加上换行符
            //writer.write("\n"); // 在第二个文件的当前行和下一个行之间加入空行
        }

        // 如果第一个文件还有剩余的行，则继续将其逐行写入合并后的 CSV 文件
        while ((line1 = reader1.readLine()) != null) {
            writer.write(line1 + "\n");
            writer.write("\n");
        }

        // 如果第二个文件还有剩余的行，则继续将其逐行写入合并后的 CSV 文件
        while ((line2 = reader2.readLine()) != null) {
            writer.write(line2 + "\n");
            writer.write("\n");
        }

        // 关闭所有的 Reader 和 Writer 对象
        reader1.close();
        reader2.close();
        writer.close();

        System.out.println("CSV 文件合并完成！");
    }
}
