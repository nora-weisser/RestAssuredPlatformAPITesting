package POJO;

import java.util.List;

public class Footer {

    private String id;
    private String title;
    private String subtitle;
    private String description;
    private List<Network> network;
    private Link link;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Network> getNetwork() {
        return network;
    }

    public void setNetwork(List<Network> network) {
        this.network = network;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
