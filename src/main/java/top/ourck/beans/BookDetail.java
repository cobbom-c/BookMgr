package top.ourck.beans;

public class BookDetail {
	
	private int id;
	private String name;
	private String ISBN;
	private String edition;
	private String chiefEditor;
	private String institute;
	private String pubDate;
	private String author;
	private float price;
	
	public BookDetail() {
		// TODO Auto-generated constructor stub
	}

	public BookDetail(int id, String name, String iSBN, String edition, String chiefEditor, String institute,
			String pubDate, String author, float price) {
		super();
		this.id = id;
		this.name = name;
		ISBN = iSBN;
		this.edition = edition;
		this.chiefEditor = chiefEditor;
		this.institute = institute;
		this.pubDate = pubDate;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getChiefEditor() {
		return chiefEditor;
	}

	public void setChiefEditor(String chiefEditor) {
		this.chiefEditor = chiefEditor;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
