package com.big3anime.backend.profiles;

public class Resource {
    private String type;
    private String resourceId;
    private String resourcename;
    private boolean isIssued;

    public Resource(){

    }
    public Resource(String type, String resourceId, String resourcename, boolean isIssued) {
        this.type = type;
        this.resourceId = resourceId;
        this.resourcename = resourcename;
        this.isIssued = isIssued;
    }

    public Resource(Resource rsrc){
        this(rsrc.type,rsrc.resourceId,rsrc.resourcename,rsrc.isIssued);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getResourceId() {
        return resourceId;
    }
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
    public String getResourcename() {
        return resourcename;
    }
    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }
    public boolean isIssued() {
        return isIssued;
    }
    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
        result = prime * result + ((resourcename == null) ? 0 : resourcename.hashCode());
        result = prime * result + (isIssued ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resource other = (Resource) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (resourceId == null) {
            if (other.resourceId != null)
                return false;
        } else if (!resourceId.equals(other.resourceId))
            return false;
        if (resourcename == null) {
            if (other.resourcename != null)
                return false;
        } else if (!resourcename.equals(other.resourcename))
            return false;
        if (isIssued != other.isIssued)
            return false;
        return true;
    }

    
}
