package org.test.project;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Java Program to parse/read HTML documents from File using Jsoup library.
 * parses an HTML document by URL and determines the total number of tables
 * JQuery like method.
 *
 * @author Austin Wilson
 */
public class htmlParser {

    public static void main(String[] args) throws IOException {

        String url = "http://en.wikipedia.org/wiki/List_of_blogs";

        Document document = Jsoup.connect(url).get();
        Elements row = document.select("tr");
        Elements table = document.select("table");
        Elements cell = document.select("td");
        System.out.println("Number of Rows are : " + row.size() + " Number of tables are : " + table.size() + " Number of cells are : " + cell.size());

    }

}