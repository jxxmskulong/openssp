package openrtb.bidresponse.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Since;

/**
 * @author André Schmer
 * @see OpenRTB-API-Specification #section Bid Object
 * @version 2.1, 2.2, 2.3, 2.4
 * 
 */
public final class Bid implements Comparable<Bid> {

	// required
	private String id;
	private String impid;// corresponding impressionid of bidrequest
	private float price;
	private String adid;
	private String nurl;
	private String adm;

	// Advertiser domain for block list checking (e.g., “ford.com”).
	// This can be an array of for the case of rotating
	// creatives. Exchanges can mandate that only one domain is allowed
	private List<String> adomain;
	private String iurl;
	private String cid;
	private String crid;
	private List<Integer> attr;

	private int api;
	private int protocol;

	@Since(2.2)
	private String dealid;
	private int h;
	private int w;

	@Since(2.3)
	// private String bundle;
	private List<String> cat;

	private Object ext;

	public Bid() {
		adomain = new ArrayList<>();
		attr = new ArrayList<>();
	}

	protected void setId(final String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getImpid() {
		return impid;
	}

	protected void setImpid(final String impid) {
		this.impid = impid;
	}

	public float getPrice() {
		return price;
	}

	protected void setPrice(final float price) {
		this.price = price;
	}

	public String getNurl() {
		return nurl;
	}

	protected void setNurl(final String nurl) {
		this.nurl = nurl;
	}

	public String getAdid() {
		return adid;
	}

	protected void setAdid(final String adid) {
		this.adid = adid;
	}

	public String getAdm() {
		return adm;
	}

	protected void setAdm(final String adm) {
		this.adm = adm;
	}

	public List<String> getAdomain() {
		return adomain;
	}

	protected void setAdomain(final List<String> adomain) {
		this.adomain = adomain;
	}

	public void addAdomain(final String adomain) {
		this.adomain.add(adomain);
	}

	public String getIurl() {
		return iurl;
	}

	protected void setIurl(final String iurl) {
		this.iurl = iurl;
	}

	public String getCid() {
		return cid;
	}

	protected void setCid(final String cid) {
		this.cid = cid;
	}

	public String getCrid() {
		return crid;
	}

	protected void setCrid(final String crid) {
		this.crid = crid;
	}

	public List<Integer> getAttr() {
		return attr;
	}

	protected void setAttr(final List<Integer> attr) {
		this.attr = attr;
	}

	public void addAttr(final Integer attr) {
		this.attr.add(attr);
	}

	public String getDealid() {
		return dealid;
	}

	protected void setDealid(final String dealid) {
		this.dealid = dealid;
	}

	public int getH() {
		return h;
	}

	protected void setH(final int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	protected void setW(final int w) {
		this.w = w;
	}

	public List<String> getCat() {
		return cat;
	}

	public void setCat(final List<String> list) {
		cat = list;
	}

	public int getApi() {
		return api;
	}

	public void setApi(final int api) {
		this.api = api;
	}

	public int getProtocol() {
		return protocol;
	}

	public void setProtocol(final int protocol) {
		this.protocol = protocol;
	}

	public Object getExt() {
		return ext;
	}

	protected void setExt(final Object ext) {
		this.ext = ext;
	}

	public List<String> getAdomainList() {
		return adomain;
	}

	public List<Integer> getAttrList() {
		return attr;
	}

	public boolean hasId() {
		return id != null && id.length() != 0;
	}

	public boolean hasAdid() {
		return adid != null && adid.length() != 0;
	}

	public Builder getBuilder() {
		return new Builder(this);
	}

	@Override
	public int compareTo(final Bid o) {
		if (o != null && (o.getPrice() > getPrice())) {
			return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		return String.format("Bid [id=%s, impid=%s, price=%s, adid=%s, nurl=%s, adm=%s, adomain=%s, iurl=%s, cid=%s, crid=%s, attr=%s, dealid=%s, h=%s, w=%s, cat=%s, ext=%s]", id,
		        impid, price, adid, nurl, adm, adomain, iurl, cid, crid, attr, dealid, h, w, cat, ext);
	}

	public static class Builder {

		private final Bid bid;

		public Builder() {
			bid = new Bid();
		}

		public Builder(final Bid bid) {
			this.bid = bid;
		}

		public Builder setId(final String id) {
			bid.setId(id);
			return this;
		}

		public Builder setImpid(final String impId) {
			bid.setImpid(impId);
			return this;
		}

		public Builder setPrice(final float d) {
			bid.setPrice(d);
			return this;
		}

		public Builder addAllAdomain(final List<String> allDomain) {
			bid.setAdomain(allDomain);
			return this;
		}

		public Builder addAdomain(final String adomain) {
			bid.addAdomain(adomain);
			return this;
		}

		public Builder addAllAttr(final List<Integer> allAttr) {
			bid.setAttr(allAttr);
			return this;
		}

		public Builder setDealid(final String dealid) {
			bid.setDealid(dealid);
			return this;
		}

		public Builder setCats(final List<String> list) {
			bid.setCat(list);
			return this;
		}

		public Builder setAdm(final String adm) {
			bid.setAdm(adm);
			return this;
		}

		public Builder setNurl(final String nurl) {
			bid.setNurl(nurl);
			return this;
		}

		public String getImpid() {
			return bid.getImpid();
		}

		public String getId() {
			return bid.getId();
		}

		public List<String> getAdomainList() {
			return bid.getAdomainList();
		}

		public List<Integer> getAttrList() {
			return bid.getAttrList();
		}

		public boolean hasId() {
			return bid.hasId();
		}

		public boolean hasAdid() {
			return bid.hasAdid();
		}

		public Object getAdid() {
			return bid.getAdid();
		}

		public Bid build() {
			return bid;
		}

	}

}
