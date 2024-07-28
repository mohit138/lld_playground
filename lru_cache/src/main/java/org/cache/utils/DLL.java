package org.cache.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DLL {
    private DLLN head;
    private DLLN tail;
    private Integer size;

    public DLL(){
        head=null;
        tail=null;
        size=0;
    }

    public void printDLL() {
        DLLN cur = head;
        while(cur!=null){
            System.out.print(cur.data+" - ");
            cur = cur.next;
        }
        System.out.println();
    }

    public DLLN insertNodeAtEnd(DLLN cur){
        if(size==0){
            head=cur;
            tail=cur;
        } else{
            cur.prev=tail;
            tail.next=cur;
            tail=cur;
            tail.next=null;
        }
        size++;
        return tail;
    }

    public DLLN detatchNode(DLLN node){
        if(node!=head){
            node.prev.next = node.next;
        }else{
            head=node.next;
        }
        if(node!=tail){
            node.next.prev = node.prev;
        }else{
            tail=node.prev;
        }
        node.next=null;
        node.prev=null;
        return node;
    }

    public void removeHead(){
        if(head!=null){
            head.next.prev=null;
            head = head.next;
        }
    }

}
