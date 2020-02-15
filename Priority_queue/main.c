#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int trigger =1;
typedef struct
{
    char name[30];
    struct Node *next;
} Node_queue;
typedef struct
{
    Node_queue * head;
    Node_queue * tail;
} queue ;
typedef struct
{
    int balance;
    queue *q;
} Node_tree;
typedef struct
{
    Node_tree *Nodes[10000];
    int end ;
} heap ;

Node_queue *constructNode_queue(char * name)
{
    Node_queue * n = malloc(sizeof(Node_queue));
    strcpy(n->name,name);
    n->next=NULL;
}
void push(queue *q,char*name)
{
    if(q->head==NULL)
    {
        q->head=constructNode_queue(name);
        q->tail=q->head;
        return ;
    }
    q->tail->next=constructNode_queue(name);
    q->tail=q->tail->next;
}
void print_queue(queue *q,int balnce)
{
    Node_queue * temp = q->head;
    while(temp!=NULL)
    {
        printf("%s %d\n",temp->name,balnce);
        temp=temp->next;
    }
}
void initQueue(queue *q)
{
    q->head=NULL;
    q->tail=NULL;
}
Node_tree *constructNode_tree(char *name,int balance)
{
    Node_tree *n = (Node_tree *)malloc(sizeof(Node_tree));
    n->q =(queue* )malloc(sizeof(queue));
    initQueue(n->q);
    push(n->q,name);
    n->balance=balance;
}
void addname(Node_tree *t,char * name)
{
    push(t->q,name);

}
int found(heap *h,int value,char *name,int start)
{
    if(start>=h->end||h->Nodes[start]==NULL)
        return 0 ;
    if(h->Nodes[start]->balance==value)
    {
        addname(h->Nodes[start],name);
        return 1;
    }
    else if(h->Nodes[start]->balance<value)
    {
        return 0 ;
    }
    else
    {
        return found(h,value,name,2*start)||found(h,value,name,2*start+1);
    }
}
void insert(heap *h,int value,char *name)
{
    int temp;
    if(found(h,value,name,1));

    else
    {
        temp=h->end++;
        h->Nodes[temp]=constructNode_tree(name,value);
        while(1)
        {
            if(temp<2)
            {
                break;
            }
            if(h->Nodes[temp/2]->balance<h->Nodes[temp]->balance)
            {
                Node_tree *tempo = h->Nodes[temp/2];
                h->Nodes[temp/2]=h->Nodes[temp];
                h->Nodes[temp]=tempo;
                temp/=2;
            }
            else
                break;
        }
    }
}
Node_tree * cons(int x, queue *q)
{
    Node_tree * t = (Node_tree *)malloc(sizeof(Node_tree));
    t->balance = x;
    t->q=q;
}
void checkfather(heap *h,int indx)
{
while(1)
{
    if(indx<2)
        break;
    if(h->Nodes[indx/2]->balance<h->Nodes[indx]->balance)
    {
       Node_tree * temp= h->Nodes[indx/2];
       h->Nodes[indx/2]=h->Nodes[indx];
       h->Nodes[indx]=temp;
       indx/=2;
    }
    else
        break;

}
}
Node_tree * pop(heap*h)
{
    int indx=1;
    Node_tree *temp = h->Nodes[1];

    while(1)
    {
        if(2*indx+1>h->end)
        {
            if(2*indx>h->end||h->Nodes[2*indx+1]==NULL)
            {

                h->Nodes[indx]=cons(h->Nodes[h->end]->balance,h->Nodes[h->end]->q);
                break;
            }
            else
                h->Nodes[indx]=cons(h->Nodes[2*indx]->balance,h->Nodes[2*indx]->q);
                indx= indx*2;
          h->Nodes[indx]=cons(h->Nodes[h->end]->balance,h->Nodes[h->end]->q);
            break ;
        }
        if((h->Nodes[2*indx]->balance )>(h->Nodes[2*indx+1]->balance))
        {
            h->Nodes[indx]=cons(h->Nodes[2*indx]->balance,h->Nodes[2*indx]->q);
            indx*=2;
        }
        else
        {
            h->Nodes[indx]=cons(h->Nodes[2*indx+1]->balance,h->Nodes[2*indx+1]->q);
            indx=indx*2+1;
        }
    }

    h->end--;
    return temp;
}
void readfromfiles(heap * h )
{
    FILE *fp = fopen("PriorityQueue.txt", "r");
    if(fp==NULL)
        printf("cannot read file");
    char name[100];
    float balance ;
    char v;
    int i ;
    while(!feof(fp))
    {
        fscanf(fp,"%s %f",name,&balance);
        insert(h,balance,name);
    }
    h->end--;
}
void floosakaboosak(heap *h)
{
    Node_tree * n;
    int temp = h->end;
    int x;
    while(temp--)
    {
        x= h->end+1;
        n= pop(h);
        print_queue(n->q,n->balance);
        free(n->q);
        free(n);
    }

}

int main()
{
    //printf("aaaa");
    heap h;
    h.end=1;
    h.Nodes[0]=NULL;
    readfromfiles(&h);
    int x = h.end+1;
    floosakaboosak(&h);
}
