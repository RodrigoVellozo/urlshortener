package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "url")
@NamedQueries(@NamedQuery(name="url.findAll", query="select u from Url as u "))
@XmlRootElement
public class Url {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String longurl;
	private String shorturl;
	
	public Url() {
	
	}
	public Url(Integer id, String longurl, String shorturl) {
		this.id = id;
		this.longurl = longurl;
		this.shorturl = shorturl;
	}
	@Override
	public String toString() {
		return "Url [id=" + id + ", longurl=" + longurl + ", shorturl=" + shorturl + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLongurl() {
		return longurl;
	}
	public void setLongurl(String longurl) {
		this.longurl = longurl;
	}
	public String getShorturl() {
		return shorturl;
	}
	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}
}
