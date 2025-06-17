package com.icecap.dao;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.icecap.dto.League;

public class LeagueDao {
  private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

  public League crawl(String url) throws IOException {
    logger.info(url);
    // So I need a certificate to connect to a URL using Jsoup. Need to learn how.
    Document doc = Jsoup.connect("https://puckpedia.com/").get();
    logger.info("URL get");
    /*
     * Element elements = doc.select("table.infobox").first();
     * logger.info("table get");
     * 
     * StringBuilder output = new StringBuilder(); for (Element row :
     * elements.select("tr").subList(1, elements.select("tr").size())) { Elements
     * col = row.select("th, td"); logger.info(col.get(0).text());
     * 
     * }
     */
    return null;
  }

  public void addLeague() {
    
  }

}
