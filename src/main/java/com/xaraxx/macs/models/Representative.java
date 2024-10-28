package com.xaraxx.macs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.util.Objects;

@Entity
public class Representative {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String lastNane;
    private String documentNumber;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "FK_document_type")
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name="FK_club")
    private Club club;

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

    public String getLastNane() {
        return lastNane;
    }

    public void setLastNane(String lastNane) {
        this.lastNane = lastNane;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Representative that = (Representative) o;
        return id.equals(that.id) && name.equals(that.name) && lastNane.equals(that.lastNane) && documentNumber.equals(that.documentNumber) && phoneNumber.equals(that.phoneNumber) && documentType.equals(that.documentType) && club.equals(that.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastNane, documentNumber, phoneNumber, documentType, club);
    }

    @Override
    public String toString() {
        return "Representative{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastNane='" + lastNane + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", documentType=" + documentType + '\'' +
                ", club=" + club + '\'' +
                '}';
    }
}
