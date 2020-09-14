package com.asopaps.asopaps.entitiesPK;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class ContributionPK implements Serializable{

	private long id_member;
	private long id_request;
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id_member);
        hash = 59 * hash + Objects.hashCode(this.id_request);
        return hash;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final ContributionPK other = (ContributionPK) obj;
        if (!Objects.equals(this.id_member, other.id_member)) {
            return false;
        }
        if (!Objects.equals(this.id_request, other.id_request)) {
            return false;
        }
        return true;
    }

	
}
