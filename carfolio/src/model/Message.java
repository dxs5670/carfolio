/*
    The Message entity class models a basic message. These messages will go 
    from user-to-user (sender to recipient). While not indicated in this class, 
    messages are also used to make an offer on a vehicle. When a potential buyer
    makes an offer, the seller will recieve a message and, when tehy check their
    portfolio, they are able to see what the most recent offer for their vehicle
    was. This is all done using the message as a model.
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


@Entity
@Table(name = "message")
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByMessageBody", query = "SELECT m FROM Message m WHERE m.messageBody = :messageBody"),
    @NamedQuery(name = "Message.findByRecipient", query = "SELECT m FROM Message m WHERE m.recipient = :recipient"),
    @NamedQuery(name = "Message.findBySender", query = "SELECT m FROM Message m WHERE m.sender = :sender"),
    @NamedQuery(name = "Message.findByTimeSent", query = "SELECT m FROM Message m WHERE m.timeSent = :timeSent"),
    @NamedQuery(name = "Message.findByMessageID", query = "SELECT m FROM Message m WHERE m.messageID = :messageID")})

public class Message implements Serializable {
    
    private static final long serialVersionUID = 1L;    
    @Id
    @Basic(optional = false)
    @Column(name = "messageID")
    private String messageID;

    @Column(name = "messageBody")
    private String messageBody;
    
    @Column(name = "recipient")
    private String recipient;
    
    @Column(name = "sender")
    private String sender;
    
    @Column(name = "timeSent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSent;
    


    // Empty Message constructor 
    public Message() {
    }

    // 
    public Message(String messageID) {
        this.messageID = messageID;
    }

    // Get and set the messageBody attribute of a message 
    // This is the contents of a message, which is preset for an offer
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    // Get and set the recipient attribute of a message 
    // This will be the user that recieves a message
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    // Get and set the sender attribute of a message 
    // The sender is whoever is logged in while sending a message
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    // Get and set the timeSent attribute of a message 
    // This will be a dynamically created date object when the message is sent
    public Date getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    // Get and set the messageID attribute of a message
    // The message ID is the unique identifying attribute of a message
    // It will be incramentted based on the last message sent
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    // Injected
    
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
