package com.sk;

import com.sk.Csv.MergeCsv;
import com.sk.Csv.ProcessCsvByString;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        // 处理 csv 单元格内以字符串形式
        String inputFile = "/Users/shaokai/Documents/test/src/main/java/org/example/商家端压测参数_实时.csv";
        String outputFile = "/Users/shaokai/Documents/test/src/main/java/org/example/output.csv";
        ProcessCsvByString processCsvByString = new ProcessCsvByString();
        processCsvByString.process(inputFile, outputFile);

        // 合并两个 csv 文件，其内容交替放入
        MergeCsv mergeCsv = new MergeCsv();
        mergeCsv.merge("/Users/shaokai/Documents/test/src/main/java/org/example/output.csv","/Users/shaokai/Documents/test/src/main/java/org/example/商家端压测参数.csv","/Users/shaokai/Documents/test/src/main/java/org/example/merge.csv");
    }
}