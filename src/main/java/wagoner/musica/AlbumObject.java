package wagoner.musica;

import java.io.File;
import java.util.Date;

public class AlbumObject {

	private Long albumObjectID;
	private Long albumID;
	private String albumName;
	private Long artistID;
	private String artistName;
	private String recordLabel;
	private String catalogNum;
	private String upcNum;
	private String country;
	private String format;
	private String formatDiameter;
	private String formatNotes;
	private String mediaCondition;
	private String sleeveCondition;
	private String conditionExt;
	private File mediaImage1;
	private File mediaImage2;
	private File mediaImage3;
	private Boolean onDiscogs; /* datatype in db is char, need to change this */
	private Date discogsDate;
	private Long ownerID;
	private String extra_1;
	private String extra_2;
	
	public Long getAlbumObjectID() {
		return albumObjectID;
	}
	public void setAlbumObjectID(Long albumObjectID) {
		this.albumObjectID = albumObjectID;
	}
	public Long getAlbumID() {
		return albumID;
	}
	public void setAlbumID(Long albumID) {
		this.albumID = albumID;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Long getArtistID() {
		return artistID;
	}
	public void setArtistID(Long artistID) {
		this.artistID = artistID;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getRecordLabel() {
		return recordLabel;
	}
	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
	public String getCatalogNum() {
		return catalogNum;
	}
	public void setCatalogNum(String catalogNum) {
		this.catalogNum = catalogNum;
	}
	public String getUpcNum() {
		return upcNum;
	}
	public void setUpcNum(String upcNum) {
		this.upcNum = upcNum;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getFormatDiameter() {
		return formatDiameter;
	}
	public void setFormatDiameter(String formatDiameter) {
		this.formatDiameter = formatDiameter;
	}
	public String getFormatNotes() {
		return formatNotes;
	}
	public void setFormatNotes(String formatNotes) {
		this.formatNotes = formatNotes;
	}
	public String getMediaCondition() {
		return mediaCondition;
	}
	public void setMediaCondition(String mediaCondition) {
		this.mediaCondition = mediaCondition;
	}
	public String getSleeveCondition() {
		return sleeveCondition;
	}
	public void setSleeveCondition(String sleeveCondition) {
		this.sleeveCondition = sleeveCondition;
	}
	public String getConditionExt() {
		return conditionExt;
	}
	public void setConditionExt(String conditionExt) {
		this.conditionExt = conditionExt;
	}
	public File getMediaImage1() {
		return mediaImage1;
	}
	public void setMediaImage1(File mediaImage1) {
		this.mediaImage1 = mediaImage1;
	}
	public File getMediaImage2() {
		return mediaImage2;
	}
	public void setMediaImage2(File mediaImage2) {
		this.mediaImage2 = mediaImage2;
	}
	public File getMediaImage3() {
		return mediaImage3;
	}
	public void setMediaImage3(File mediaImage3) {
		this.mediaImage3 = mediaImage3;
	}
	public Boolean getOnDiscogs() {
		return onDiscogs;
	}
	public void setOnDiscogs(Boolean onDiscogs) {
		this.onDiscogs = onDiscogs;
	}
	public Date getDiscogsDate() {
		return discogsDate;
	}
	public void setDiscogsDate(Date discogsDate) {
		this.discogsDate = discogsDate;
	}
	public Long getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
	}
	public String getExtra_1() {
		return extra_1;
	}
	public void setExtra_1(String extra_1) {
		this.extra_1 = extra_1;
	}
	public String getExtra_2() {
		return extra_2;
	}
	public void setExtra_2(String extra_2) {
		this.extra_2 = extra_2;
	}

	
}
