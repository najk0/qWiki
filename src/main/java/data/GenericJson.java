package data;

import org.json.JSONObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericJson {
    private JSONObject json;


    public GenericJson(JSONObject json) {
        this.json = json;
    }
}
