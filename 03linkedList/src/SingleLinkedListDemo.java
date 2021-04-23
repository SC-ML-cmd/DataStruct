/**
 * @author Wsc
 * @create 2021-04-05 21:29
 */

import java.util.Stack;

/**
 * @program: DataStruct
 * @description:单向链表
 * @author: Wsc
 * @create: 2021-04-05 21:29
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(new LinkNode(1, "宋江", "及时雨"));
        singleLinkedList.addNode(new LinkNode(2, "卢俊义", "玉麒麟"));
        singleLinkedList.addNode(new LinkNode(3, "智多星", "吴用"));
        //显示添加的节点
        System.out.println("显示添加节点后链表");
        SingleLinkedList.showLinkList(singleLinkedList.getHead());


        singleLinkedList.del(1);
        System.out.println("显示删除节点后链表");
        SingleLinkedList.showLinkList(singleLinkedList.getHead());

        singleLinkedList.insert(new LinkNode(5, "wsc", "墨白非攻"));
        singleLinkedList.insert(new LinkNode(4, "wsc", "小橘子"));
        System.out.println("显示插入节点后链表");
        SingleLinkedList.showLinkList(singleLinkedList.getHead());

        singleLinkedList.update(new LinkNode(4, "WSC", "大橘猫"));
        System.out.println("显示更新后节点");
        SingleLinkedList.showLinkList(singleLinkedList.getHead());

        //当前有效节点个数
        System.out.println("当前有效节点个数" + SingleLinkedList.getCount(singleLinkedList.getHead()));

        //第k个节点
        System.out.println("倒数第3个节点:" + SingleLinkedList.getBackwardNode(singleLinkedList.getHead(), 3).toString());

        //翻转链表
        LinkNode head = singleLinkedList.getHead();
        SingleLinkedList.getReverseLinkedList(head);
        System.out.println("翻转链表后结果:" );
        SingleLinkedList.showLinkList(head);

        //再次翻转输出链表
        System.out.println("再次翻转输出链表:");
        SingleLinkedList.reverseShowLinkList(head);
    }


}
class SingleLinkedList{
    //获取链表中有效节点个数
    public  static int getCount(LinkNode head){
        LinkNode temp = head.next;
        int count = 0;
        while (temp != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }

    //获取倒数第k个节点
    public static LinkNode getBackwardNode(LinkNode head, int k){
        int size = getCount(head);

        LinkNode temp = head.next;
        int curIndex = 0;
        while (temp != null){
            //以3个节点为例，倒数第3个节点，即正数第3-3 = 0个节点， 倒数第1个节点即正数第3-1 = 2 个节点
            //以size个有效节点为列，倒数第k个节点，即正数第size-k个节点
            if (curIndex == size - k){
                return temp;
            }
            temp = temp.next;
            curIndex ++;
        }
        return null;
    }

    //获取反转链表
    public static void getReverseLinkedList(LinkNode head){
        LinkNode reverseHead = new LinkNode(0, "", "");
        LinkNode curNode = head.next;
        LinkNode nextNode = null;
        while (curNode != null){
            //记录当前节点的下一个节点
            nextNode = curNode.next;

            curNode.next = reverseHead.next;
            reverseHead.next = curNode;

            //将下一个节点赋给当前节点
            curNode = nextNode;
        }
        head.next = reverseHead.next;
    }
    public static void getReverseLinkedList2(LinkNode head){
        LinkNode reverseHead = new LinkNode(0, "", "");

        LinkNode temp = null;
        while (head.next != null){
            //获取原链表的第一个节点
            temp = head.next;
            //将该节点取出
            head.next = temp.next;
//            if (temp.next != null){
//                head.next = temp.next;
//            }else {
//                head.next = null;
//            }

            temp.next = reverseHead.next;
            reverseHead.next = temp;
//            if (reverseHead.next == null){
//                reverseHead.next = temp;
//            }else {
//                temp.next = reverseHead.next;
//                reverseHead.next = temp;
//            }
        }
        head.next = reverseHead.next;
    }

    //遍历输出链表
    public static void showLinkList(LinkNode head){
        LinkNode temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //反向遍历输出链表
    public static void reverseShowLinkList(LinkNode head){
        Stack<LinkNode> nodeStack = new Stack<>();
        LinkNode temp = head.next;
        while (temp != null){

            nodeStack.push(temp);
            temp = temp.next;
        }
        //nodeStack.forEach(System.out::println);

        while (nodeStack.size() > 0){
            System.out.println(nodeStack.pop());
        }
    }


    private LinkNode head = new LinkNode(0, "", "");

    public LinkNode getHead(){
        return head;
    }


    //添加节点
    public void addNode(LinkNode node){
        LinkNode temp = head;
        //定位到尾结点
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    //删除节点 找到前一个节点，才能删除
    public void del(int no){
        LinkNode temp = head;

        //当前节点下一个节点为空时，跳出循环
        while(temp.next != null){
            if (temp.next.no == no){
                temp.next = temp.next.next;

            }
            temp = temp.next;
        }
    }

    //修改节点
    public  void update(LinkNode newLinkNode){
        LinkNode temp = head.next;
        while(temp != null){
            //找到修改节点位置后，修改节点
            if (temp.no == newLinkNode.no){
                temp.name = newLinkNode.name;
                temp.nickName = newLinkNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    //插入节点
    public void insert(LinkNode newLinkNode){
        LinkNode temp = head;
        while(temp != null){

            if (temp.next != null && newLinkNode.no < temp.next.no){
                newLinkNode.next = temp.next;
                temp.next = newLinkNode;
                //及时退出循环
                break;
            }else if (temp.next == null){
                temp.next = newLinkNode;
                break;
            }
            temp = temp.next;
        }
    }

}
class LinkNode{
    public  int no;
    public String name;
    public String nickName;
    public LinkNode next;

    public LinkNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}