package com.sunwell.product.model;



/*
 
* Merk.java
 *
 * Created on February 8, 2007, 4:49 PM
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="merk")
//@NamedQueries ({
//    @NamedQuery(name = "Merk.findAll", query = "SELECT m FROM Merk m ORDER BY m.name"),
//    @NamedQuery(name = "Merk.find", query = "SELECT m FROM Merk m WHERE m.systemId = :systemId")
//})
public class Merk implements Comparable<Merk>
{
    /** PRIMARY KEY ; auto-increment */
	@Id
    @SequenceGenerator (name = "merk_systemid_seq", sequenceName = "merk_systemid_seq", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "merk_systemid_seq" )
//	@GeneratedValue (strategy = GenerationType.AUTO )
    @Column (name = "systemid")
    private int systemId;
    
    /** Must be UNIQUE. */
    @NotNull(message="{error_no_name}")
    @Column(name="name", unique = true)
    private String name;
    
    @Column(name="manufacturer")
    private String manufacturer;
    
    /**
     * Merk's description
     */
    @Column(name="memo")
    private String memo;

    /**
     * @roseuid 45C9A40200EA
     */
    public Merk()
    {
        
    }
    
    public Merk(Integer _i)
    {
        systemId = _i;
    }
    
    public Merk(String _name)
    {
        name = _name;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int _idMerk) {
        systemId = _idMerk;
    }

    public String getName() {
        return name;
    }

    public void setName(String _merkName) {
        name = _merkName;
    }
    

    public String getManufacturerName() 
    {
        return manufacturer;
    }

    public void setManufacturerName(String _vendorName) 
    {
        manufacturer = _vendorName;
    }

    public String getDesc()
    {
        return memo;
    }

    public void setDesc(String _memo)
    {
        memo = _memo;
    }

    

    @Override
    public String toString ()
    {
        return name;
    }

    @Override
    public boolean equals (Object _obj)
    {
    	if(_obj == null)
    		return false;
        if (!(_obj instanceof Merk)) {
            return false;
        }
        
        Merk other = (Merk) _obj;
        return systemId == other.systemId;
    }

    @Override
    public int compareTo (Merk _o)
    {
        return name.compareTo (_o.getName ());
    }
   
}
