package org.example;

public class Sugar extends Subject{
    public Sugar(int weight)
    {
        super(weight);
    }
    public void pour(Cup cup)
    {
        cup.fillSugar(this);
        // Poured sugar into a cup and the sugar weight decreased
        this.setWeight(0);
    }
}
