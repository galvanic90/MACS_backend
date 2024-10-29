package com.xaraxx.macs.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Athlete {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String lastName;
    private String idNumber;
    private String sex;
    private String birthDate;
    private double weight;
    private String pictureUrl;
    @ManyToOne
    @JoinColumn(name="FK_club")
    private Club club;
    @ManyToOne
    @JoinColumn(name="FK_document_type")
    private DocumentType documentType;
    @ManyToOne
    @JoinColumn(name="FK_belt_grade")
    private BeltGrade belt;
    @ManyToOne
    @JoinColumn(name="FK_country")
    private Country homeland;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public BeltGrade getBelt() {
        return belt;
    }

    public void setBelt(BeltGrade belt) {
        this.belt = belt;
    }

    public Country getHomeland() {
        return homeland;
    }

    public void setHomeland(Country homeland) {
        this.homeland = homeland;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Athlete athlete))
            return false;
        return Objects.equals(this.id, athlete.id) && Objects.equals(this.name, athlete.name) && Objects.equals(this.lastName, athlete.lastName)
                && Objects.equals(this.idNumber, athlete.idNumber) && Objects.equals(this.sex, athlete.sex) && Objects.equals(this.birthDate, athlete.birthDate)
                && Objects.equals(this.weight, athlete.weight) && Objects.equals(this.pictureUrl, athlete.pictureUrl) && Objects.equals(this.club, athlete.club)
                && Objects.equals(this.documentType, athlete.documentType) && Objects.equals(this.belt, athlete.belt) && Objects.equals(this.homeland, athlete.homeland);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.lastName, this.idNumber, this.sex, this.birthDate, this.weight, this.pictureUrl, this.club, this.documentType, this.belt, this.homeland);
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", weight=" + weight +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", club=" + club + '\'' +
                ", documentType=" + documentType + '\'' +
                ", belt=" + belt + '\'' +
                ", homeland=" + homeland + '\'' +
                '}';
    }
}
