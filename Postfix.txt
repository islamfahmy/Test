#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

/*
 * Item: An item that is being pushed to or popped from the stack
 *       It may be float (to be used while evaluating the postfix)
 *       It may be char* (to be used while converting infix to postfix)
 */
typedef union
{
    float fData;
    char* cpData;
} Item;
/*
 *
 */
typedef struct
{
    /* TODO: ADD YOUR CODE HERE */
    Item data;
    struct Node *link;
} Node;

typedef struct
{
    /* TODO: ADD YOUR CODE HERE */
    Node* upperMost;
} Stack;
/*
 *
 */
void init(Stack *s)
{
    /* TODO: ADD YOUR CODE HERE */
    s->upperMost = NULL;
}
/*
 *
 */
int isEmpty(Stack *s)
{
    /* TODO: ADD YOUR CODE HERE */
    if(s->upperMost == NULL)
        return 1;
    else
        return 0;
}
/*
 *
 */
Item top(Stack *s)
{
    /* TODO: ADD YOUR CODE HERE */
    return s->upperMost->data;
}
/*
 *
 */
Item pop(Stack *s)
{
    /* TODO: ADD YOUR CODE HERE */
    Node *tempNode;
    Item tempItem;
    tempItem = s->upperMost->data;
    tempNode = s->upperMost;
    s->upperMost = s->upperMost->link;
    //tempNode->link = NULL;
    free(tempNode);
    return tempItem;
}
/*
 *
 */
void push(Stack *s, Item val)
{
//    si
    Node* tempNode = (Node*)malloc(sizeof(Node)+sizeof(val));
    if(tempNode == NULL)
        printf("ERROR DURING MEMORY ALLOCATING \n");
    tempNode->data = val;
    tempNode->link = s->upperMost;
    s->upperMost = tempNode;
}
/*
 *
 */
void destroy(Stack *s)
{
    /* TODO: ADD YOUR CODE HERE */
    Node *tempNode;
    while(s->upperMost !=NULL)
    {
        tempNode = s->upperMost;
        s->upperMost = s->upperMost->link;
        tempNode->link = NULL;
        free(tempNode);
    }
}
/*
 * infixToPostfix: converts an expression in infix notation to
 *					to a postfix notation (Reverse-Polish Notation)
 *					ASSUME single-digit operands
 *					ASSUME ^*+-/ operators
 *					e.g., 2+3 --> 23+
 *					e.g., (2+3)*4 --> 23+4*
 */
int isNumber(char x)
{
    if((int)x >= 48 && (int)x <= 57)
        return 1;
    return 0;
}

int precedence(char c)
{
    if(c == '+' || c == '-')
        return 1;
    else if(c == '*' || c == '/')
        return 2;
    else if(c == '^')
        return 3;
    return 0;
}
void infixToPostfix(char* infix, char* postfix)
{
    /* TODO: ADD YOUR CODE HERE */
    Stack s;
    init(&s);
    Item x;
    x.cpData='(';
    push(&s,x);
    while (*infix!='\n'&&*infix!='\0')
    {
        while (*infix==' ')
            infix++;
        //printf("infix = %c\n",*infix);
        if(isNumber(*infix))
        {
            while(*infix!=' '&&*infix!='\n')
                *postfix++ = *infix++;
            *postfix++=' ';
        }
        else
        {   x = top(&s);
           // printf("opernad = %c\n",*infix);
            if(*infix==')')
            {
                x=pop(&s);
                while(x.cpData!='(')
                {    *postfix++=x.cpData;
                    *postfix++=' ';
                    x=pop(&s);
                }

                infix++;

                       }
                       else if(*infix=='(')
                       {
                           x.cpData=*infix++;
                           push(&s,x);
                       }
                else if(precedence(x.cpData) >= precedence(*infix))
            {
                 x = pop(&s);
                *postfix++ = x.cpData;
                *postfix++=' ';
                // printf("infix = %c %c %c\n ",*infix,infix++,infix++);
                x.cpData=*infix++;
                push(&s,x);
                x=top(&s);

            }
            else
            {
                x.cpData=*infix++;
                push(&s,x);
            }
        }

    }
    //printf("last 3aks %d ",isEmpty(&s));
    x=pop(&s);
    while(x.cpData!='(')
    {
        *postfix++=x.cpData;
        *postfix++=' ';

        x=pop(&s);
    }
   *--postfix='\0';
}
/*
 * evaluatePostfix: Evaluates an expression in postfix notation
 *					 (Reverse-Polish Notation)
 *					ASSUME single-digit operands
 */
float evaluatePostfix(char* postfix)
{
  Item x; char arr[100];
    while(*postfix!='\0')
    {
        while(*postfix==' ')
            postfix++;
        if(isNumber(*postfix))
        {    int i=0;
             while(*postfix!=' ')
              arr[i++]=*postfix++;
            float r=atof(arr);
            //printf("%f \n",r);
            x.fData=r;
            push(&s,x);

        }
        else
        {

        printf("%c",*postfix);
           float r,f,s;
           Item x;
           printf("empty = %d",isEmpty(&s)) ;
           x=pop(&s);
           f=x.fData;
           s=pop(&s).fData;
            switch(*postfix)
            {
                case '+':r=f+s;break;
                case '-':r=s-f;break;
                case '/':r=s/f;break;
                case '*':r=f*s;break;

            }
            x.fData =r;push(&s,x);
            printf("loop");
        }
   postfix++;
    }
    return pop(&s).fData;
}
/*
 *
 */
void replaceNewLineBySpace(char *s)
{
    char *s1 = s;
    while((s1 = strstr(s1, "\n")) != NULL)
        *s1 = ' ';
}
/*
 *
 */
int main(int argc, char**argv)
{
    char infixExpr[256] = "";
    char postfixExpr[256] = "";

    printf("Enter an expression you want to evaluate or Ctrl+Z to exit: ");
    while(fgets(infixExpr, 255, stdin) != NULL)
    {
        //replaceNewLineBySpace(infixExpr);

        infixToPostfix(infixExpr, postfixExpr);
        printf("Postfix : %s\n", postfixExpr);

        float result = evaluatePostfix(postfixExpr);
        printf("Result: %f\n\n", result);

        printf("Enter an expression you want to evaluate or Ctrl+Z to exit: ");
    }
    return 0;
}
