package wagoner.musica;

import java.io.File;


public class Album {

	private Long albumID;
	private Artist artist;
	private String albumName;
	private String releaseDate;
	private String label;
	private String genre;
	private String style;
	private Long ratingDave;
	private File coverImage;
	private String notes;
	private Boolean compilationFlag;

	public long getAlbumID() {
		return albumID;
	}
	public void setAlbumID(long albumID) {
		this.albumID = albumID;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Long getRatingDave() {
		return ratingDave;
	}
	public void setRatingDave(Long ratingDave) {
		this.ratingDave = ratingDave;
	}
	public File getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(File coverImage) {
		this.coverImage = coverImage;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Boolean getCompilationFlag() {
		return compilationFlag;
	}
	public void setCompilationFlag(Boolean compilationFlag) {
		this.compilationFlag = compilationFlag;
	}
	
}

/*
to load an image file:

File fnew=new File("/tmp/rose.jpg");
BufferedImage originalImage=ImageIO.read(fnew);
ByteArrayOutputStream baos=new ByteArrayOutputStream();
ImageIO.write(originalImage, "jpg", baos );
byte[] imageInByte=baos.toByteArray();

OR

import java.nio.file.Files;
import java.io.File;

File fi = new File("myfile.jpg");
byte[] fileContent = Files.readAllBytes(fi.toPath())

OR

BufferedImage image = ImageIO.read(new File("filename.jpg"));
// Process image
ImageIO.write(image, "jpg", new File("output.jpg"));
*/