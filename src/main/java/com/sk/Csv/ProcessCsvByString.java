package com.sk.Csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 处理 csv 文件到新 csv 文件
// 对每个单元格以字符串形式处理
public class ProcessCsvByString {
    public void process(String inputFile, String outputFile){
        try {
            // 创建 CSVReader 对象读取输入文件
            CSVReader reader = new CSVReader(new FileReader(inputFile));

            // 创建 CSVWriter 对象写入输出文件
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile));

            String[] line;


            // 读取并写入 CSV 文件的每一行
            int j = 0;
            while ((line = reader.readNext()) != null) {
                // 修改每个单元格的字符串为大写
                for (int i = 0; i < line.length; i++) {
                    // 每个单元格 String 进行处理
                    line[i] = line[i].replace("20230509", "20230510");
                    line[i] = line[i].replace("20230508", "20230509");
                }
                // 写入修改后的行
                writer.writeNext(line);
            }

            // 关闭 reader 和 writer 对象
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
