nums = [1,2,3,4,3]
stack=[]
ans=[-1]*len(nums)

for _ in range(2):
    for i in range(len(nums)):
        while stack and nums[stack[-1]]<nums[i]:
            ans[stack.pop()]=nums[i]

        stack.append(i)
            
print(ans)