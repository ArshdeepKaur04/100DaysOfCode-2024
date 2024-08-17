class Solution {
  public:
    Node* segregate(Node* head) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        Node* temp = head;
    
        while (temp != NULL) {
            if (temp->data == 0) {
                zeroCount++;
            }
            else if (temp->data == 1) {
                oneCount++;
            }
            else if (temp->data == 2) {
                twoCount++;
            }
            temp = temp -> next;
        }
    
        temp = head;
        while (temp != NULL) {
            while (zeroCount) {
                temp->data = 0;
                temp = temp->next;
                zeroCount--;
            }
            while(oneCount) {
                temp->data = 1;
                temp = temp->next;
                oneCount--;
            }
            while(twoCount) {
                temp->data = 2;
                temp = temp->next;
                twoCount--;
            }
        }
    
        return head;
    }
};
