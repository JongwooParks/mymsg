import ChatViewComponent from '@/views/messenger/chatting/ChatView.vue'

const DmChatRouter = [
    {
        path : '/:roomId/chat',
        name : 'ChatRoom',
        component : ChatViewComponent,
        props: true
    }
]

export default DmChatRouter;