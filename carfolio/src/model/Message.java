/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dstet
 */
@Entity
@Table(name = "Message")
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByMessageBody", query = "SELECT m FROM Message m WHERE m.messageBody = :messageBody"),
    @NamedQuery(name = "Message.findByRecipient", query = "SELECT m FROM Message m WHERE m.recipient = :recipient"),
    @NamedQuery(name = "Message.findBySender", query = "SELECT m FROM Message m WHERE m.sender = :sender"),
    @NamedQuery(name = "Message.findByTimeSent", query = "SELECT m FROM Message m WHERE m.timeSent = :timeSent"),
    @NamedQuery(name = "Message.findByMessageID", query = "SELECT m FROM Message m WHERE m.messageID = :messageID")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "messageBody")
    private String messageBody;
    @Column(name = "recipient")
    private String recipient;
    @Column(name = "sender")
    private String sender;
    @Column(name = "timeSent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSent;
    @Id
    @Basic(optional = false)
    @Column(name = "messageID")
    private String messageID;

    public Message() {
    }

    public Message(String messageID) {
        this.messageID = messageID;
    }

    public Message(String messageID, String messageBody) {
        this.messageID = messageID;
        this.messageBody = messageBody;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageID != null ? messageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageID == null && other.messageID != null) || (this.messageID != null && !this.messageID.equals(other.messageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Message[ messageID=" + messageID + " ]";
    }
    
}
