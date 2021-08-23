package hu.ulyssys.java.course.exam.entity;


import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
public abstract class AbstractPizza extends AbstractEntity  {

    @Column(name = "modification_date")
    @Temporal(TemporalType.DATE)
    private Date modificationDate;

    @JoinColumn(name = "creator_id")
    @ManyToOne
    private AppUser creator;

    @JoinColumn(name = "modifier_user_id")
    @ManyToOne
    private AppUser modifierUser;


    public AbstractPizza() {
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public AppUser getCreator() {
        return creator;
    }

    public void setCreator(AppUser creator) {
        this.creator = creator;
    }

    public AppUser getModifierUser() {
        return modifierUser;
    }

    public void setModifierUser(AppUser modifierUser) {
        this.modifierUser = modifierUser;
    }
}
