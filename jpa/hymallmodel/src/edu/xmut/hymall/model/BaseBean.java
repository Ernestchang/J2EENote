package edu.xmut.hymall.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public class BaseBean implements Serializable {
	private static final long serialVersionUID = 2067621005909246965L;
	protected String id;
	protected Integer version;
	protected Boolean deleted = false;
	protected Date dateCreated;
	protected Date dateModified;

	@Id
	@Column(length = 36, insertable = false, updatable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(nullable = false)
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "date_created", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "date_modified", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@PrePersist
	public void prePersist() {
		dateCreated = new Date();
		id = UUID.randomUUID().toString();
	}

	@PreUpdate
	public void preUpdate() {
		dateCreated = new Date();
	}
}
