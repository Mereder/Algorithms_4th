package com.mereder.Algs_Exercise.Exercises1_3;

import java.io.File;

public class FileList {
    // 这个队列用的很奇怪，过程中队列中都是只有一个元素
    Queue<File> queue = new Queue<>();
    
    public void addQueue(File file,int depth){

        if (file.exists()){
            queue.Enqueue(file);
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.println(queue.Dequeue().getName());
            if (file.isDirectory()){
                File[] list = file.listFiles();
                for (File temp:list){
                    addQueue(temp,depth+1);
                }
            }
            else
                return;
        }
        else return;
    }

    public static void main(String[] args) {
       FileList test = new FileList();
       String rootname = "E:\\filetest";
       File root = new File(rootname);
       test.addQueue(root,0);
       System.out.println();
    }

}
