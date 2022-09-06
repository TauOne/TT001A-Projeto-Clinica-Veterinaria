/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author saina
 */
public class Exame {
    private int codExam;
    private String descExam;
    private String resulExam;

    public Exame(int codExam, String descExam, String resulExam) {
        this.codExam = codExam;
        this.descExam = descExam;
        this.resulExam = resulExam;
    }

    public int getCodExam() {
        return codExam;
    }

    public String getDescExam() {
        return descExam;
    }

    public String getResulExam() {
        return resulExam;
    }

    public void setDescExam(String descExam) {
        this.descExam = descExam;
    }

    public void setResulExam(String resulExam) {
        this.resulExam = resulExam;
    }
    
    
}
