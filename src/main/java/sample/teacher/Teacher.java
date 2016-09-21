/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.teacher;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author quangphuong
 */
@Entity
@Table(name = "Teacher", catalog = "QUANGPX", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findById", query = "SELECT t FROM Teacher t WHERE t.id = :id"),
    @NamedQuery(name = "Teacher.findByName", query = "SELECT t FROM Teacher t WHERE t.name = :name"),
    @NamedQuery(name = "Teacher.findByAddr", query = "SELECT t FROM Teacher t WHERE t.addr = :addr"),
    @NamedQuery(name = "Teacher.findByPhone", query = "SELECT t FROM Teacher t WHERE t.phone = :phone")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "addr", length = 100)
    private String addr;
    @Column(name = "phone", length = 15)
    private String phone;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String addr, String phone) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
    }

    public Teacher(String name, String addr, String phone) {
        this.name = name;
        this.addr = addr;
        this.phone = phone;
    }
    
    public Teacher(Integer id) {
        this.id = id;
    }

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.teacher.Teacher[ id=" + id + " ]";
    }
    
}
