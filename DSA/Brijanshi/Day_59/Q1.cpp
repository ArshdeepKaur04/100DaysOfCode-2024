#include <iostream>
using namespace std;

struct Node{
    int data;
    Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
};

class Solution {
  public:
    Node *compute(Node *head) {
        if (head == NULL || head->next == NULL) return head;

        // Reverse the linked list
        Node* prev = NULL;
        Node* curr = head;
        Node* next = NULL;
        
        while (curr != NULL) {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        Node* maxNode = head;
        curr = head->next;
        prev = head;
        
        // Traverse the reversed list and remove nodes
        while (curr != NULL) {
            if (curr->data < maxNode->data) {
                prev->next = curr->next;
            } else {
                maxNode = curr;
                prev = curr;
            }
            curr = curr->next;
        }
        
        // Reverse the list again to restore the original order
        prev = NULL;
        curr = head;
        next = NULL;
        
        while (curr != NULL) {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev; // The new head of the modified list
    }
};
