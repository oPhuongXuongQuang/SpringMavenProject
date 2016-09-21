/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.news;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import sample.category.Category;
import sample.staff.Staff;

/**
 *
 * @author quangphuong
 */
@Entity
@Table(name = "News", catalog = "QUANGPX", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsId", query = "SELECT n FROM News n WHERE n.newsId = :newsId"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findBySummary", query = "SELECT n FROM News n WHERE n.summary = :summary"),
    @NamedQuery(name = "News.findByContents", query = "SELECT n FROM News n WHERE n.contents = :contents"),
    @NamedQuery(name = "News.findByCreatedDate", query = "SELECT n FROM News n WHERE n.createdDate = :createdDate")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "newsId", nullable = false)
    private Integer newsId;
    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;
    @Size(max = 250)
    @Column(name = "summary", length = 250)
    private String summary;
    @Size(max = 1073741823)
    @Column(name = "contents", length = 1073741823)
    private String contents;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "categoryId", referencedColumnName = "category_id", nullable = false)
    @ManyToOne(optional = false)
    private Category categoryId;
    @JoinColumn(name = "staffId", referencedColumnName = "staffId", nullable = false)
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Staff staffId;

    public News() {
    }

    public News(Integer newsId, String title, String summary, String contents, Date createdDate, Staff staffId, Category categoryId) {
        this.newsId = newsId;
        this.title = title;
        this.summary = summary;
        this.contents = contents;
        this.createdDate = createdDate;
        this.staffId = staffId;
        this.categoryId = categoryId;
    }

    public News(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsId != null ? newsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsId == null && other.newsId != null) || (this.newsId != null && !this.newsId.equals(other.newsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.staff.News[ newsId=" + newsId + " ]";
    }
    
}
