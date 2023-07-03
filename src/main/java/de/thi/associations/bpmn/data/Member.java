package de.thi.associations.bpmn.data;


/**
 * @author Daniel Mehlber
 */
public class Member {

    private String name;
    private boolean cancelled;

    private float monthlyFee;

    public Member(String name, float fee) {
        this.name = name;
        cancelled = false;
        monthlyFee = fee;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public float getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(float monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
}
