package com.microframework.solrcloud.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class Solrtest {

	public static void main(String[] args) {

		
		
		int i  = SolrDB.getDataCount();
		
		ConcurrentUpdateSolrServer server = new ConcurrentUpdateSolrServer(
				"http://192.168.1.105:8983/solr/fangdata", 5000, 100);

		
		int page = i/100000;
		System.out.println("总页数:"+page);
		for(int m = 0;m<page;m++){
			System.out.println("页数:"+m);
			List<FangData> fd = SolrDB.getdata(m);
			 Iterator<FangData> fds = fd.iterator();
			Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();

			while(fds.hasNext()){
				FangData fdata = fds.next();
				SolrInputDocument doc = new SolrInputDocument();
				
				doc.addField("Name", fdata.getName());
				doc.addField("CardNo", fdata.getCardNo());
				doc.addField("Descriot", fdata.getDescriot());
				doc.addField("ctftp", fdata.getCtftp());
				doc.addField("ctfid", fdata.getCtfid());
				doc.addField("gender", fdata.getGender());
				doc.addField("birthday", fdata.getBirthday());
				doc.addField("address", fdata.getAddress());
				doc.addField("zip", fdata.getZip());
				doc.addField("dirty", fdata.getDirty());
				doc.addField("district1", fdata.getDistrict1());
				doc.addField("district2", fdata.getDistrict2());
				doc.addField("district3", fdata.getDistrict3());
				doc.addField("district4", fdata.getDistrict4());
				doc.addField("district5", fdata.getDistrict5());
				doc.addField("district6", fdata.getDistrict6());
				doc.addField("firstnm", fdata.getFirstnm());
				doc.addField("lastnm", fdata.getLastnm());
				doc.addField("duty", fdata.getDuty());
				doc.addField("mobile", fdata.getMobile());
				doc.addField("tel", fdata.getTel());
				doc.addField("fax", fdata.getFax());
				doc.addField("email", fdata.getEmail());
				doc.addField("nation", fdata.getNation());
				doc.addField("teste", fdata.getTeste());
				doc.addField("education", fdata.getEducation());
				doc.addField("company", fdata.getCompany());
				doc.addField("ctel", fdata.getCtel());
				doc.addField("caddress", fdata.getCaddress());
				doc.addField("czip", fdata.getCzip());
				doc.addField("family", fdata.getFamily());
				doc.addField("version", fdata.getVersion());
				doc.addField("id", fdata.getId());
				
				docs.add(doc);
			}
			
			
			try {
				server.add(docs);
				server.optimize();
				server.commit();
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
