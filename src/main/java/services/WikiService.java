package services;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.sun.org.apache.xpath.internal.SourceTree;
import data.*;
import api.WikiAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api")
public class WikiService {

    private WikiAPI api;

    public WikiService() {
        api = new WikiAPI();
    }

    @GET
    @Produces({"application/json"})
    @Path("{title}")
    @JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
    public Response retrieve(@PathParam("title") String title) {
        Article article = api.getArticle(title);
        System.out.println("Requested article: " + title);
        System.out.println(article);

        return  Response
                .status(Response.Status.OK)
                .entity(article)
                .build();
    }

    @GET
    @Produces({"application/json"})
    @Path("{title}/sections")
    public Response retrieveSections(@PathParam("title") String title) {
        Article article = api.getArticle(title);
        System.out.println("Article sections for: " + title);

        return Response
                .status(Response.Status.OK)
                .entity(article.getSections())
                .build();
    }


    @GET
    @Produces({"application/json"})
    @Path("{keywords}/search")
    public Response search(@PathParam("keywords") String keywords) {
        SearchResults results = api.getSearchResults(keywords);
        System.out.println("Searched for: " + keywords);

        return  Response
                .status(Response.Status.OK)
                .entity(results)
                .build();
    }


    @GET
    @Produces({"application/json"})
    @Path("{keywords}/info")
    public Response getArticleInfo(@PathParam("keywords") String keywords) {
        ArticleInfo info = api.getArticleInfo(keywords);
        System.out.println("Search for article \"" + keywords +
                "\" returned article: " + info.getArticleName());

        return  Response
                .status(Response.Status.OK)
                .entity(info)
                .build();
    }

}