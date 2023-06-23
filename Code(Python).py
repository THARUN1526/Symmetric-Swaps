for _ in range(int(input())):
    N=int(input())
    arr1=list(map(int,input().split(' ')))
    arr2=list(map(int,input().split(' ')))
    for i in range(N):
        # If element of arr1 is less than element of arr2 then swap it
        if arr1[i]<arr2[i]:
            arr1[i],arr2[i]=arr2[i],arr1[i]
    arr=[]
    for i in range(N):
        col=[]
        col.append(arr1[i])  # Col1 is arr1
        col.append(arr2[i])  # Col2 is arr2
        arr.append(col)  # append two columns in 2d array
    arr.sort()
    arr1Min,arr1Max,arr2Min,arr2Max=[0]*N,[0]*N,[0]*N,[0]*N
    arr1Min[0]=arr[0][0]  # 1st element is min
    arr1Max[0]=arr[0][0]  # can be any element so 1st element is max
    arr2Min[N-1]=arr[N-1][1] # right to left min
    arr2Max[N-1]=arr[N-1][1] # right to left max
    for i in range(1,N):
        arr1Min[i]=min(arr1Min[i-1],arr[i][0]) # every element of arr1 checked with other element for minimum
        arr1Max[i]=max(arr1Min[i-1],arr[i][0]) # every element of arr1 checked with other element for maximum
    for i in range(N-2,-1,-1):
        arr2Min[i]=min(arr2Min[i+1],arr[i][1]) # every element of arr2 checked with other elements for minimum
        arr2Max[i]=max(arr2Max[i+1],arr[i][1]) #every element of arr2 checked with toher elements for maximum
    ans=arr[N-1][0]-arr[0][0] # Maximum - Minimum
    for i in range(N-1,-1,-1):
        if i==0:
            maximum=arr2Max[0] # 1st element max
            minimum=arr2Min[0] # 1st element min
        else:
            maximum=max(arr1Max[i-1],arr2Max[i]) # max of arr1 and arr2
            minimum=min(arr1Min[i-1],arr2Min[i]) # min of arr1 and arr2
        ans=min(ans,maximum-minimum) # ans is min of ans and max - min
    print(ans)