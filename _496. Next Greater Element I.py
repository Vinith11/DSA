nums1=[4,1,2]
nums2=[1,3,4,2]
# nums1=[2,4]
# nums2=[1,2,3,4]
ans=[-1]*len(nums1)

num1Id={n:i for i, n in enumerate(nums1)}
res=[-1]*len(nums1)

stack=[]
for i in range(len(nums2)):
    cur=nums2[i]
    while stack and cur>stack[-1]:
        val=stack.pop()
        idx=num1Id[val]
        res[idx]=cur
    if cur in num1Id:
        stack.append(cur)

print(res)
