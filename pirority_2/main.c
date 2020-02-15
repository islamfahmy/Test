
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
 * Item: Each Item has a customer name and a balance.
 *       and an integer order(it is used to handle the case when two items have same priority)
*/
typedef struct
{
    char* cName;
    double balance;
    int order;
} Item;
/*
 * Heapify index i in array of Items with size n
 */
void max_heapify(Item *arr, int n, int i)
{
    /* TODO: ADD YOUR CODE HERE */
}
/*
 * Construct Priority queue from the given array of Items with size n(Build Max Heap)
 */
void push(Item *arr,int end)
{
    int start = 1;
    while(1)
    {
        if(end<2)
            break ;
        if(arr[end/2].balance<arr[end].balance)
        {
            Item x =arr[end/2];
            arr[end/2]=arr[end];
            arr[end]=x;
            end  =end/2;
        }
        else if(arr[end/2].balance==arr[end].balance)
        {
            if(arr[end/2].order>arr[end].order)
            {
                Item x =arr[end/2];
                arr[end/2]=arr[end];
                arr[end]=x;
                end  = end/2;
            }
            else
                break;
        }
        else
            break;
    }
}
void construct_PQ(Item*arr,int n)
{
    int i =2 ;
    while(i<=n)
    {
        push(arr,i++);
    }
}
/*
 * delete the item with max priority and then return it.
 */
Item extract_maximum(Item*arr,int n)
{
    /* TODO: ADD YOUR CODE HERE */
}
/*
 * read array of items from file in arr and return its size.
 */
int fillArrayFromFile(char*fname,Item*arr)
{
    int count=0 ;
    FILE *fp = fopen("PriorityQueue.txt", "r");
    if(fp==NULL)
        printf("cannot read file");
    char name[100];
    double balance ;
    while(!feof(fp))
    {
        count++;
        fscanf(fp,"%s %lf",name,&balance);
        arr[count].cName= (char*)malloc(strlen(name));
        strcpy(arr[count].cName,name);
        arr[count].balance=balance;
        arr[count].order=count-1;
    }
    return count;
}
/*
 * print customer names in decreasing order according their priority.
 */
Item  pop(Item*arr,int end)
{
    Item  rage3 = arr[1];
    int i =1 ;
    Item temp;
    while(1)
    {
        if(2*i+1>end)
        {
            if(2*i>end)
            {   arr[i]=arr[end];
                push(arr,i);
                break;
            }
            arr[i] =arr[2*i];
            arr[2*i]=arr[end];
                push(arr,2*i);

            break;

        }
            if(arr[2*i+1].balance==arr[2*i].balance)
            {
                if(arr[2*i+1].order<arr[2*i].order)
                {
                    arr[i]=arr[2*i+1];
                    i= 2*i+1;
                }
                else
                {
                    arr[i]=arr[2*i];
                    i*=2;
                }
            }

        else if(arr[2*i+1].balance>arr[2*i].balance)
        {
            arr[i]=arr[2*i+1];
            i= 2*i+1;
        }
        else
        {
            arr[i]=arr[2*i];
            i*=2;
        }
    }


    return rage3;
}
void printCustomersbyPriority(Item*arr,int n)
{  int i = n +1;
int c =1;
   while(i-->1)
   {
       Item x = pop(arr,n--);
       printf("%d. %s %f\n",c++,x.cName,x.balance);
   }
}
/*
 *
 */
int main(int argc, char**argv)
{

    if(argc!=2)
    {
        printf("Usage: %s filename\n", argv[0]);
        //	exit(1);
    }
    Item *customers=(Item*)malloc(sizeof(Item)*1000);
    int arrLength=fillArrayFromFile(argv[1],customers);
    construct_PQ(customers,arrLength);
     printCustomersbyPriority(customers,arrLength);
    return 0;
}
