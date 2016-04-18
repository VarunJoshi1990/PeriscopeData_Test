# -*- coding: utf-8 -*-
"""
Created on Mon Apr 18 11:25:21 2016

@author: Varun Joshi
"""

if __name__ == "__main__":
    f=open("input.txt","r")
    #Read the range of coordinates for room
    m,n=map(int,f.readline().split())
    temp=""
    #Initialise with no dirt spots
    #This is a bitmap and hence the space complexity will be less as well
    ds=[[False for i in range(n)] for j in range(m)]
    count=0
    #Read the initial spot
    x,y=map(int,f.readline().split())
    try:
        #Try- block for reading till I get a string of directions 
        #                            which will raise a exception
        while True:
           temp=f.readline()
           i,j=map(int,temp.split())    
           ds[i][j]=True         #True indicates a dirt spot
    except:
        #Got the directions
        #check whether the initial spot itself is dirty
        if ds[x][y]:
            ds[x][y]=False
            count+=1
        #Act according to instructions and stop if invalid
        for i in temp:
            if i=="N" and y<m-1:
                y+=1
            elif i=="S" and y>0:
                y-=1
            elif i=="E" and x<n-1:
                x+=1
            elif i=="W" and x>0:
                x-=1
            if ds[x][y]:
                ds[x][y]=False
                count+=1
    
    #This is for Python 2
    #print repr(x)+" "+repr(y)
    #print count
    
    
    #This is for Python 3
    print (x,y)
    print (count)
    f.close()